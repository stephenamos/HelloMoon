package com.bignerdranch.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {

	MediaPlayer mPlayer;

	public void stop() {
		if (mPlayer != null) {
			mPlayer.release();
			mPlayer = null;
		}
	}

	public void pause() {
		if (mPlayer != null) {
			if (mPlayer.isPlaying()) {
				mPlayer.pause();
			} else {
				mPlayer.start();
			}
		}
	}

	public void play(Context c) {
		stop(); //Prevents multiple instances of play() from occuring

		mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
		mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

			@Override
			public void onCompletion(MediaPlayer mp) { //Ensures only one mediaplayer at any given time
				stop();
			}
		});


		mPlayer.start();
	}

}
