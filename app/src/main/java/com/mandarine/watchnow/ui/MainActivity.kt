package com.mandarine.watchnow.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.mandarine.watchnow.R
import com.mandarine.watchnow.databinding.ActivityMainBinding
import com.mandarine.watchnow.ui.movies.MoviesFragment

class MainActivity : AppCompatActivity(), MoviesFragment.Listener {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rootFragment = MoviesFragment().apply { setListener(this@MainActivity) }

        savedInstanceState ?: supportFragmentManager.beginTransaction().apply {
            add(R.id.container, rootFragment, null)
            commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun changeFragmentById(id: Int) {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, MoviesDetailsFragment.newInstance(id), null)
            addToBackStack(null)
            commit()
        }
    }

    fun changeFragment(id: Int) {
        val detailFragment = MoviesDetailsFragment.newInstance(id)
        supportFragmentManager.beginTransaction().apply {
            add(R.id.container, detailFragment, null)
            addToBackStack(null)
            commit()
        }
    }
}