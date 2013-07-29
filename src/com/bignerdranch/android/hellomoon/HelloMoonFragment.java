package com.bignerdranch.android.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment {

	private AudioPlayer mPlayer = new AudioPlayer();

	private Button mPlayButton;
	private Button mPauseButton;
	private Button mStopButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true); //Retains the fragment, allowing smooth media playback when rotating the screen
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_hello_moon, parent, false);

		mPlayButton = (Button) view.findViewById(R.id.hellomoon_playButton);
		mPlayButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				mPlayer.play(getActivity());

			}
		});

		mPauseButton = (Button) view.findViewById(R.id.hellomoon_pauseButton);
		mPauseButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				mPlayer.pause();

			}
		});

		mStopButton = (Button) view.findViewById(R.id.hellomoon_stopButton);
		mStopButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				mPlayer.stop();
			}
		});

		return view;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mPlayer.stop();
	}


}
