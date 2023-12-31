package com.example.tugaspapb7

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tugaspapb7.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PASS = "extra_pass"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        val usernameInput = binding.usernameInput
        val passwordInput = binding.passwordInput
        val login = binding.login

        val user = arrayOf("Adi", "Budi", "Andi", "Supomo")
        val pass = mapOf(
            user[0] to "1234",
            user[1] to "2341",
            user[2] to "3412",
            user[3] to "4123"
        )

        fun isLoginValid(username: String, password: String): Boolean {
            val storedPassword = pass[username]
            return storedPassword != null && storedPassword == password
        }
        login.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            if (isLoginValid(username, password)) {
                val intentLoginFragment =
                    Intent(requireContext(), HomeActivity::class.java)
                intentLoginFragment.putExtra(EXTRA_NAME, username)
                intentLoginFragment.putExtra(EXTRA_PASS, password)
                startActivity(intentLoginFragment)
            } else {
                Toast.makeText(requireContext(), "Username atau Password tidak sesuai", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}