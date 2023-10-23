package com.example.tugaspapb7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.tugaspapb7.LoginFragment.Companion.EXTRA_NAME
import com.example.tugaspapb7.RegisterFragment.Companion.EXTRA_NAME1
import com.example.tugaspapb7.databinding.HomeBinding

class HomeActivity : AppCompatActivity() {
        private lateinit var binding: HomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val username = intent.getStringExtra(EXTRA_NAME)
        val username1 = intent.getStringExtra(EXTRA_NAME1)
        with(binding){
            name1.text = username1
            name.text = username
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.dashboard, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                Toast.makeText(this@HomeActivity, "Logout", Toast.LENGTH_SHORT).show()
                val intentHomeActivity =
                    Intent(this, MainActivity::class.java)
                startActivity(intentHomeActivity)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}