package screenrecorder;

import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.VideoFormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ScreenRecorderUtil extends ScreenRecorder {
    public static ScreenRecorder screenRecorder;
    public String name;

    public ScreenRecorderUtil(GraphicsConfiguration cfg, Rectangle captureArea, Format fileFormat, Format screenFormat, Format mouseFormat, Format audioFormat, File movieFolder, String name) throws IOException, AWTException {
        super(cfg, captureArea, fileFormat, screenFormat, mouseFormat, audioFormat, movieFolder);
        this.name = name;
    }

    protected File createMovieFile(Format fileFormat) throws IOException {
        if (!this.movieFolder.exists()) {
            this.movieFolder.mkdirs();
        } else if (!this.movieFolder.isDirectory()) {
            throw new IOException("\"" + String.valueOf(this.movieFolder) + "\" is not a directory.");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
        String var10003 = this.name;
        return new File(this.movieFolder, var10003 + "-" + dateFormat.format(new Date()) + "." + Registry.getInstance().getExtension(fileFormat));
    }

    public static void startRecord(String methodName) throws Exception {
        File file = new File("./test-recordings/");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        Rectangle captureSize = new Rectangle(0, 0, width, height);
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        screenRecorder = new ScreenRecorderUtil(gc, captureSize, new Format(new Object[]{FormatKeys.MediaTypeKey, MediaType.FILE, FormatKeys.MimeTypeKey, "video/avi"}), new Format(new Object[]{FormatKeys.MediaTypeKey, MediaType.VIDEO, FormatKeys.EncodingKey, "tscc", VideoFormatKeys.CompressorNameKey, "tscc", VideoFormatKeys.DepthKey, 24, FormatKeys.FrameRateKey, Rational.valueOf(15.0), VideoFormatKeys.QualityKey, 1.0F, FormatKeys.KeyFrameIntervalKey, 900}), new Format(new Object[]{FormatKeys.MediaTypeKey, MediaType.VIDEO, FormatKeys.EncodingKey, "black", FormatKeys.FrameRateKey, Rational.valueOf(30.0)}), (Format)null, file, methodName);
        screenRecorder.start();
    }

    public static void stopRecord() throws Exception {
        screenRecorder.stop();
    }
}
