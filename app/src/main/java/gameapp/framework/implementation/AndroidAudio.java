package gameapp.framework.implementation;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.provider.MediaStore;

import java.io.IOException;

import gameapp.framework.Audio;
import gameapp.framework.Music;
import gameapp.framework.Sound;

/**
 * Created by Pierce on 3/9/2016.
 * FIXME: Figure out why the class isn't implementing correctly
 */
public class AndroidAudio implements Audio {
    AssetManager assets;
    SoundPool.Builder soundPoolBuilder;
    AudioAttributes.Builder audioBuilder;
    AudioAttributes audioAttributes;
    SoundPool soundPool;

    public AndroidAudio(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        this.assets = activity.getAssets();

        audioBuilder.setContentType(AudioAttributes.CONTENT_TYPE_MUSIC);
        audioBuilder.setUsage(AudioAttributes.USAGE_GAME);
        this.audioAttributes = audioBuilder.build();

        soundPoolBuilder.setMaxStreams(20);
        soundPoolBuilder.setAudioAttributes(audioAttributes);
        this.soundPool = soundPoolBuilder.build();
    }

    @Override
    public Music createMusic(String filename) {
        try {
            AssetFileDescriptor assetDescriptor = assets.openFd(filename);
            return new AndroidMusic(assetDescriptor);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load music '" + filename + "'");
        }
    }

    @Override
    public Sound createSound(String filename) {
        try {
            AssetFileDescriptor assetDescriptor = assets.openFd(filename);
            int soundId = soundPool.load(assetDescriptor, 0);
            return new AndroidSound(soundPool, soundId);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't load sound '" + filename + "'");
        }
    }
}
