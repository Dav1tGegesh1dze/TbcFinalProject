package com.example.middlecourseproject.presentation.ar

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.example.middlecourseproject.databinding.ActivityFoodArBinding
import com.google.ar.core.*
import io.github.sceneview.SceneView
import io.github.sceneview.math.Position
import io.github.sceneview.node.ModelNode
import kotlinx.coroutines.launch

class FoodArActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFoodArBinding
    private lateinit var sceneView: SceneView

    private var dishId: String = ""
    private var dishName: String = ""
    private var restaurantCategoryId: String = ""
    private var restaurantName: String = ""

    private val CAMERA_PERMISSION_CODE = 100
    private var arSession: Session? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodArBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dishId = intent.getStringExtra("DISH_ID") ?: ""
        dishName = intent.getStringExtra("DISH_NAME") ?: ""
        restaurantCategoryId = intent.getStringExtra("RESTAURANT_CATEGORY_ID") ?: ""
        restaurantName = intent.getStringExtra("RESTAURANT_NAME") ?: ""

        Log.d("FoodArActivity", "Received data: dishId=$dishId, dishName=$dishName")

        binding.closeArButton.setOnClickListener { finish() }

        checkCameraPermission()
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                CAMERA_PERMISSION_CODE
            )
        } else {
            loadModel()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadModel()
            } else {
                Toast.makeText(this, "Camera permission is required for AR", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }

    private fun loadModel() {
        sceneView = binding.arSceneView


        val modelFileName = when {
            restaurantCategoryId == "fast_food" -> {
                if (restaurantName.contains("McDonald", ignoreCase = true)) {
                    "burger.glb"
                } else if (restaurantName.contains("Domino", ignoreCase = true)) {
                    "pizza.glb"
                } else {
                    when {
                        dishName.contains("burger", ignoreCase = true) -> "burger.glb"
                        dishName.contains("pizza", ignoreCase = true) -> "pizza.glb"
                        else -> "generalFood.glb"
                    }
                }
            }
            restaurantCategoryId == "japanese" -> "sushi.glb"
            else -> "generalFood.glb"
        }

        Log.d("FoodArActivity", "Selected model: $modelFileName")

        lifecycleScope.launch {
            try {
                val modelNode = ModelNode(engine = sceneView.engine)

                modelNode.loadModelGlb(
                    context = this@FoodArActivity,
                    glbFileLocation = "models/$modelFileName",
                    scaleToUnits = 0.2f,
                    centerOrigin = Position(0f, 0f, 0f),
                    autoAnimate = true
                )

                sceneView.addChild(modelNode)
                Toast.makeText(this@FoodArActivity, "Model loaded successfully! Use pinch gestures to resize.", Toast.LENGTH_SHORT).show()

            } catch (e: Exception) {
                Log.e("FoodArActivity", "Error loading model: ${e.message}", e)
                Toast.makeText(this@FoodArActivity, "Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::sceneView.isInitialized) {
            sceneView.destroy()
        }
        arSession?.close()
    }
}