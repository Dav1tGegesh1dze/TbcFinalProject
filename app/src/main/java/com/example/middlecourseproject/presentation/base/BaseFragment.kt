package com.example.middlecourseproject.presentation.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(
    private val bindingInflater: (inflater: LayoutInflater) -> VB
) : Fragment() {

    private var _binding: VB? = null
    val binding: VB
        get() = _binding ?: throw IllegalStateException("Binding is null, view might be destroyed")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        try {
            _binding = bindingInflater.invoke(inflater)
            return binding.root
        } catch (e: Exception) {
            Log.e(javaClass.simpleName, "Error inflating view binding: ${e.message}", e)
            throw e
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            start()
        } catch (e: Exception) {
            Log.e(javaClass.simpleName, "Error starting fragment: ${e.message}", e)
        }
    }

    abstract fun start()

    override fun onDestroyView() {
        try {
            // Clean up any resources before clearing binding
        } catch (e: Exception) {
            Log.e(javaClass.simpleName, "Error in onDestroyView: ${e.message}", e)
        } finally {
            _binding = null
            super.onDestroyView()
        }
    }
}