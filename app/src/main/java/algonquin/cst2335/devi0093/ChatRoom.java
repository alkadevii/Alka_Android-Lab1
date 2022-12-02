package algonquin.cst2335.devi0093;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import algonquin.cst2335.devi0093.databinding.ActivityChatRoomBinding;
import algonquin.cst2335.devi0093.databinding.SentMessageBinding;
import algonquin.cst2335.devi0093.databinding.RecieveMessageBinding;

public class ChatRoom extends AppCompatActivity {
    private ActivityChatRoomBinding binding;
    private RecyclerView.Adapter<MyRowHolder> myAdapter;
    ArrayList<ChatMessage> messages;
    ChatRoomViewModel chatModel;
    ChatMessageDAO mDAO;
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);

        return super.onCreateOptionsMenu(menu);


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.item_1:
                Toast.makeText(this, "Deleting the last message", Toast.LENGTH_LONG).show();
                int position=messages.size()-1;
                AlertDialog.Builder builder = new AlertDialog.Builder( ChatRoom.this );
                builder.setMessage("Do you want to delete the message: ")
                        .setTitle("Question");
                       // .setNegativeButton("No",(dialog,cl) -> {}
                        //.setPositiveButton("Yes",(dialog, cl) -> {
                            ChatMessage m=messages.get(position);

                            messages.remove(position);
                            myAdapter.notifyItemRemoved(position);


                break;
            case R.id.item_2:

                Snackbar.make(binding.myToolbar, "Version 1.0, created by Alka Devi", BaseTransientBottomBar.LENGTH_LONG).show();
                break;
        }
        return true;}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatRoomBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());
        setSupportActionBar(binding.myToolbar);

        MessageDatabase db = Room.databaseBuilder(getApplicationContext(), MessageDatabase.class, "database-name").build();
        mDAO = db.cmDAO();

        chatModel = new ViewModelProvider(this).get(ChatRoomViewModel.class);
        messages = chatModel.messages.getValue();
        if(messages == null)
        {
            chatModel.messages.setValue(messages = new ArrayList<>());

            Executor thread = Executors.newSingleThreadExecutor();
            thread.execute(() ->
            {
                messages.addAll( mDAO.getAllMessages() ); //Once you get the data from database

                runOnUiThread( () ->  binding.recycleView.setAdapter( myAdapter )); //You can then load the RecyclerView
            });
        }
        chatModel.selectedMessage.observe(this, (newMessageValue) -> {
            MessageDetailsFragment chatFragment = new MessageDetailsFragment( newMessageValue );
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentlocation, chatFragment).addToBackStack("").commit();
        });



        binding.recycleView.setAdapter(myAdapter = new RecyclerView.Adapter<MyRowHolder>() {
            @NonNull
            @Override
            public MyRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                if (viewType == 0) {
                    SentMessageBinding sendBinding = SentMessageBinding.inflate(getLayoutInflater());
                    return new MyRowHolder(sendBinding.getRoot());
                } else {
                    RecieveMessageBinding receiveBinding = RecieveMessageBinding.inflate(getLayoutInflater());
                    return new MyRowHolder(receiveBinding.getRoot());
                }

            }

            @Override
            public void onBindViewHolder(@NonNull MyRowHolder holder, int position) {
                holder.messageText.setText("");
                holder.timeText.setText("");

                ChatMessage obj = messages.get(position);
                holder.messageText.setText(obj.getMessage());
                holder.timeText.setText(obj.getTimeSent());
            }

            @Override
            public int getItemCount() {
                return messages.size();
            }

            @Override
            public int getItemViewType(int position) {
                if (messages.get(position).getIsSentButton() == true) {
                    return 0;
                } else {
                    return 1;
                }

            }
        });

        binding.sendButton.setOnClickListener(click -> {
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd-MMM-yyy hh-mm-ss a");
            String currentDateandTIme = sdf.format(new Date());
            ChatMessage newMessage = new ChatMessage(binding.textInput.getText().toString(), currentDateandTIme, true);

            Executor thread = Executors.newSingleThreadExecutor();
            thread.execute(()->{  mDAO.insertMessage(newMessage);  });


            messages.add(newMessage);
            myAdapter.notifyItemInserted(messages.size() - 1);
            binding.textInput.setText("");
        });

        binding.receiveButton.setOnClickListener(click -> {
            SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd-MMM-yyy hh-mm-ss a");
            String currentDateandTIme = sdf.format(new Date());
            ChatMessage newMessage = new ChatMessage(binding.textInput.getText().toString(), currentDateandTIme, false);

            Executor thread = Executors.newSingleThreadExecutor();
            thread.execute(()->{  mDAO.insertMessage(newMessage);  });


            messages.add(newMessage);
            myAdapter.notifyItemInserted(messages.size() - 1);
            binding.textInput.setText("");
        });
        binding.recycleView.setLayoutManager(new LinearLayoutManager(this));
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd-MMM-yyy hh-mm-ss a");
        String currentDateandTIme = sdf.format(new Date());

    }

    class MyRowHolder extends RecyclerView.ViewHolder {
        TextView messageText;
        TextView timeText;

        public MyRowHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(clk -> {
                int position = getAbsoluteAdapterPosition();
                ChatMessage selected = messages.get(position);

                chatModel.selectedMessage.postValue(selected);
                });
                /*
                AlertDialog.Builder builder = new AlertDialog.Builder( ChatRoom.this );
                builder.setMessage("Do you want to delete the message: "+messageText.getText())
                .setTitle("Question")
                .setNegativeButton("No",(dialog,cl) -> {})
                .setPositiveButton("Yes",(dialog, cl) -> {
                    ChatMessage m=messages.get(position);

                    messages.remove(position);
                    myAdapter.notifyItemRemoved(position);
                    Snackbar.make(messageText,"You deleted a message #"+position,Snackbar.LENGTH_LONG)
                            .setAction("Undo",ckl -> {
                                messages.add(position,m);
                                myAdapter.notifyItemInserted(position);
                            })
                            .show();
                })
                        .create().show();

                 */

                messageText = itemView.findViewById(R.id.message);
                timeText = itemView.findViewById(R.id.time);
            }
    }
}