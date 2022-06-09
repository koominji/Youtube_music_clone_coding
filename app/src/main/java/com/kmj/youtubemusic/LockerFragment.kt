package com.kmj.youtubemusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kmj.youtubemusic.databinding.ActivityHomeFragmentBinding
import com.kmj.youtubemusic.databinding.ActivityLockerFragmentBinding

class LockerFragment : Fragment() {
    lateinit var binding : ActivityLockerFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityLockerFragmentBinding.inflate(inflater,container,false)
        return binding.root


    }
}