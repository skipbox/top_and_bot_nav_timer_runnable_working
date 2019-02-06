package com.example.template_1;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link my_frag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link my_frag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class my_frag extends Fragment {
/*
*working with Android Studio 3.3

https://stackoverflow.com/questions/18324555/android-copy-existing-project-with-new-name-in-android-studio

I'm following these steps and it's been working so far:

1. Copy and paste the folder as used to.
2. Open Android Studio (v3.0.1).*3.3 works too
3. Select Open an existing Project.
4. Close the message that will pop up with title: "Import Gradle Projects".
5. At left side on Android Tab go to: app -> java -> select the first folder (your project folder)
6. Refactor => Rename... (Shift + F6)
7. Rename Package, Select both options - Put the new folder's name in lowercase.
8. Do Refactor
*not available in 3.0.1 on the menu
9. Select: Sync Project with Gradle Files at toolbar.
10. Build => Clean Project
11. Go to app -> res -> values -> strings.xml, and change the app name at 2nd line.

so basically
1-copy folder
2-refactor
3-sync with gradle
4-clean project
5-edit strings.xml

*/




//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//makes the text view scroll
//TextView t1= (TextView) findViewById(R.id.t1);
//t1.setMovementMethod(new ScrollingMovementMethod());
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$


//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//MediaPlayer.create(getApplicationContext(), R.raw.door_bell).start();
//should release media player maybe stop before play
//got to res >> new >> android resource directory >>> name folder raw
// in the file paste the mp3 hh
//private void stopPlaying() { if (mp != null){ mp.stop();mp.release();mp = null;}}
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$




    //my_frag.count_it();
    static int my_x = 0;
    public static int count_it() {
        my_x++;
        return my_x;
    }

    //my_frag.count_2(3);
    static int my_y = 0;
    public static int count_it_2(int i) {
        my_y = my_y+i;
        return my_y;
    }








    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public my_frag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment my_frag.
     */
    // TODO: Rename and change types and number of parameters
    public static my_frag newInstance(String param1, String param2) {
        my_frag fragment = new my_frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_frag, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
