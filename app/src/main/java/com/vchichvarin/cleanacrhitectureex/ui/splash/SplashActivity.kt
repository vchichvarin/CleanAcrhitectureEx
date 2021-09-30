package com.vchichvarin.cleanacrhitectureex.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vchichvarin.cleanacrhitectureex.App
import com.vchichvarin.cleanacrhitectureex.R
import com.vchichvarin.cleanacrhitectureex.databinding.ActivitySplashBinding
import com.vchichvarin.cleanacrhitectureex.domain.di.factory.ViewModelFactory
import com.vchichvarin.cleanacrhitectureex.domain.interactors.SplashViewModel
import com.vchichvarin.cleanacrhitectureex.ui.main.MainScreenFlowFragment
import javax.inject.Inject

class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory : ViewModelFactory
    lateinit var viewModel : SplashViewModel

    private lateinit var binding: ActivitySplashBinding

    private lateinit var fragment: Fragment

    companion object {
        const val MAIN_FRAGMENT = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.appComponent.inject(this)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, viewModelFactory).get(SplashViewModel::class.java)

        viewModel.fragmentState.observe(this, {
            replaceFragment(it)
        })

        Handler().postDelayed({
            viewModel.replaceFragment(MAIN_FRAGMENT)
        }, 2000)

    }

    // Для перемещения между Flow-фрагментами
    private fun replaceFragment(number: Int) {
        when (number) {
            MAIN_FRAGMENT -> fragment = MainScreenFlowFragment()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(number.toString())
            .commit()
    }
}