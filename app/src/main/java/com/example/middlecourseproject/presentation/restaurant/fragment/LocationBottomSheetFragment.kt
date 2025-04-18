package com.example.middlecourseproject.presentation.restaurant.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.middlecourseproject.databinding.FragmentLocationBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class LocationBottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentLocationBottomSheetBinding? = null
    private val binding get() = _binding!!

    private var onLocationSelectedListener: ((latitude: Double, longitude: Double, address: String?) -> Unit)? = null
    private var onCurrentLocationRequestedListener: (() -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocationBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnClose.setOnClickListener {
            dismiss()
        }

        binding.btnUseCurrentLocation.setOnClickListener {
            onCurrentLocationRequestedListener?.invoke()
            dismiss()
        }

        binding.selectedAddressContainer.setOnClickListener {
            dismiss()
        }

        binding.btnAddNewAddress.setOnClickListener {
            showAddAddressDialog()
        }

        binding.btnMyAddresses.setOnClickListener {
            Toast.makeText(requireContext(), "My addresses feature coming soon", Toast.LENGTH_SHORT).show()
        }

        binding.btnBrowseAllCities.setOnClickListener {
            Toast.makeText(requireContext(), "Cities browser coming soon", Toast.LENGTH_SHORT).show()
        }
    }

    fun setOnLocationSelectedListener(listener: (latitude: Double, longitude: Double, address: String?) -> Unit) {
        onLocationSelectedListener = listener
    }

    fun setOnCurrentLocationRequestedListener(listener: () -> Unit) {
        onCurrentLocationRequestedListener = listener
    }

    fun updateLocationDisplay(latitude: Double, longitude: Double, address: String?) {
        binding.tvCoordinates.text = "${String.format("%.5f", latitude)}°N ${String.format("%.5f", longitude)}°E"
        binding.tvCityName.text = address ?: "Unknown location"
    }

    private fun showAddAddressDialog() {
        val editText = EditText(requireContext())
        editText.hint = "Enter address (street, city, etc.)"

        AlertDialog.Builder(requireContext())
            .setTitle("Add New Address")
            .setView(editText)
            .setPositiveButton("Save") { _, _ ->
                val addressText = editText.text.toString()
                if (addressText.isNotEmpty()) {
                    onLocationSelectedListener?.invoke(0.0, 0.0, addressText)
                    dismiss()
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "LocationBottomSheetFragment"
    }
}