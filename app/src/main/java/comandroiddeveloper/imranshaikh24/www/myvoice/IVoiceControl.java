package comandroiddeveloper.imranshaikh24.www.myvoice;

/**
 * Created by root on 24/2/18.
 */
public interface IVoiceControl {
    public abstract void processVoiceCommands(String... voiceCommands); // This will be executed when a voice command was found

    public void restartListeningService(); // This will be executed after a voice command was processed to keep the recognition service activated
}

