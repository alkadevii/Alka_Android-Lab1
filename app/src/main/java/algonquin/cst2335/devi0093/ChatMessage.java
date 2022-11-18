package algonquin.cst2335.devi0093;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ChatMessage")
public class ChatMessage {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    public int id;
    @ColumnInfo(name="message")
    public String message;
    @ColumnInfo(name="timeSent")
    public String timeSent;
    @ColumnInfo(name = "isSentButton")
    public boolean isSentButton;
    public  ChatMessage(){

    }

    public ChatMessage(String m, String t, boolean sent){
        message=m;
        timeSent=t;
        isSentButton=sent;
    }


    public String getMessage(){
        return this.message;
    }
    public String getTimeSent(){
        return this.timeSent;
    }
    public boolean getIsSentButton(){
        return this.isSentButton;
    }


}
