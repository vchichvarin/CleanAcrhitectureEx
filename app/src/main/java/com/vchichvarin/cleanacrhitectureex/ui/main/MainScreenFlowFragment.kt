package com.vchichvarin.cleanacrhitectureex.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vchichvarin.cleanacrhitectureex.App
import com.vchichvarin.cleanacrhitectureex.databinding.FragmentMainFlowBinding
import com.vchichvarin.cleanacrhitectureex.domain.di.factory.ViewModelFactory
import com.vchichvarin.cleanacrhitectureex.domain.interactors.MainScreenViewModel
import com.vchichvarin.cleanacrhitectureex.domain.interactors.SplashViewModel
import javax.inject.Inject

class MainScreenFlowFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var mainScreenViewModel: MainScreenViewModel
    private lateinit var activityViewModel : SplashViewModel

    private var _binding: FragmentMainFlowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMainFlowBinding.inflate(layoutInflater)

        App.appComponent.inject(this)

        mainScreenViewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(MainScreenViewModel::class.java)
        activityViewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(SplashViewModel::class.java)

        mainScreenViewModel.loadedInfo.observe(requireActivity(), {
            binding.infoText.text = it.toString()
        })

        mainScreenViewModel.loadSomeInfo()

        return binding.root
    }

}