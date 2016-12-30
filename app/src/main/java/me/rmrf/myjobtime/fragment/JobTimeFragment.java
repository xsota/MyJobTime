package me.rmrf.myjobtime.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.rmrf.myjobtime.activity.MainActivity;
import me.rmrf.myjobtime.R;
import me.rmrf.myjobtime.databinding.FragmentJobTimeBinding;

public class JobTimeFragment extends Fragment {
    private static final String ARG_PARAM = "page";
    private String mParam;
    private OnFragmentInteractionListener mListener;
    private FragmentJobTimeBinding binding;

    private MainActivity parentMainActivity;

    // コンストラクタ
    public JobTimeFragment() {
    }

    public static JobTimeFragment newInstance(int page) {
        JobTimeFragment fragment = new JobTimeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM, page);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(parentMainActivity == null ) {
            parentMainActivity = (MainActivity) getActivity();
        }

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_job_time, container, false);
        View view = binding.getRoot();

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
