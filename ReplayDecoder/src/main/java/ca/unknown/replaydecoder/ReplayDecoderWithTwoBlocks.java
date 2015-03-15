package ca.unknown.replaydecoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReplayDecoderWithTwoBlocks extends ReplayDecoder {



    public ReplayDecoderWithTwoBlocks(ReplayFileReader fileReader) {
        super(fileReader);
    }

    public void decode() {
        String replayExtracted =
            replayFileReader.getReplayName().substring(0, replayFileReader.getReplayName().indexOf(".wotreplay"));

        String JSON = "C:\\replays\\" + replayExtracted + ".json";
        File file = new File(JSON);
        try {
            FileOutputStream jsonData = new FileOutputStream(file);
            jsonData.write(replayFileReader.getFirstBlock().getBytes());
            jsonData.write(replayFileReader.getSecondBlock().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.decode();

    }
}


