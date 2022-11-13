package algonquin.cst2335.devi0093;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ChatMessage {
    String message;
    String timeSent;
    boolean isSentButton;

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

    @ColumnInfo(name="message")
    protected String messages;
    @ColumnInfo(name="TimeSent")
    protected String TimeSent;
    @ColumnInfo(name="SendOrReceive")
    protected int sendOrReceive;
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name="id")
    public int id;


}
