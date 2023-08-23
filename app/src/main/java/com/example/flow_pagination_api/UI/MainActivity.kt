package com.example.flow_pagination_api.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flow_pagination_api.R
import com.example.flow_pagination_api.UI.Adapter.DogsAdapter
import com.example.flow_pagination_api.UI.Adapter.LoadingStateAdapter
import com.example.flow_pagination_api.UI.ViewModel.MainViewModel
import com.example.flow_pagination_api.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private  val mainViewModel:MainViewModel by viewModels()
    @Inject
    lateinit var dogsAdapter :DogsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initrecyclerview()
        lifecycleScope.launchWhenStarted {
            mainViewModel.getAllDogs().collectLatest {response->
                binding.apply {
                    recyclerview.isVisible=true
                    progressBar.isVisible=false
                }
                dogsAdapter.submitData(response)
            }
        }

    }

    private fun initrecyclerview() {
        binding.apply {
            recyclerview.apply {
                setHasFixedSize(true)
                layoutManager=GridLayoutManager(this@MainActivity,2)
                adapter= dogsAdapter.withLoadStateHeaderAndFooter(
                    header = LoadingStateAdapter{ dogsAdapter.retry() },
                    footer = LoadingStateAdapter{ dogsAdapter.retry() }
                )
            }
        }
    }

}