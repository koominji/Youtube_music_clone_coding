package com.kmj.youtubemusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kmj.youtubemusic.databinding.ActivityLockerFragmentBinding
import com.kmj.youtubemusic.databinding.ActivityLookFragmentBinding

class LookFragment : Fragment() {
    lateinit var binding : ActivityLookFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityLookFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }
}