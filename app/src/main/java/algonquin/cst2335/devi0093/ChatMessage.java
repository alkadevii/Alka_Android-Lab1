package algonquin.cst2335.devi0093;
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
}
