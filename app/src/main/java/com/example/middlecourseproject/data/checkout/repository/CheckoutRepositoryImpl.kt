package com.example.middlecourseproject.data.checkout.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.middlecourseproject.domain.cart.repository.CartRepository
import com.example.middlecourseproject.domain.checkout.model.DeliveryAddress
import com.example.middlecourseproject.domain.checkout.model.PaymentMethod
import com.example.middlecourseproject.domain.checkout.repository.CheckoutRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

// Extension for DataStore
val Context.checkoutDataStore: DataStore<Preferences> by preferencesDataStore(name = "checkout_preferences")

@Singleton
class CheckoutRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val cartRepository: CartRepository,
    private val json: Json
) : CheckoutRepository {

    private object PreferencesKeys {
        val DELIVERY_ADDRESS = stringPreferencesKey("delivery_address")
        val DEFAULT_PAYMENT_METHOD = stringPreferencesKey("default_payment_method")
        val PAYMENT_METHODS = stringPreferencesKey("payment_methods")
    }

    override suspend fun getDeliveryAddress(): DeliveryAddress {
        val addressJson = context.checkoutDataStore.data
            .map { preferences ->
                preferences[PreferencesKeys.DELIVERY_ADDRESS]
            }
            .first()

        return if (addressJson != null) {
            json.decodeFromString<DeliveryAddress>(addressJson)
        } else {
            // Default mock address if none is saved
            DeliveryAddress(
                coordinates = "41°48'3.25188''N 44°46'41.83536''E",
                details = "Home\nEntrance / Staircase: Feradze street"
            )
        }
    }

    override suspend fun updateDeliveryAddress(deliveryAddress: DeliveryAddress) {
        val addressJson = json.encodeToString(deliveryAddress)
        context.checkoutDataStore.edit { preferences ->
            preferences[PreferencesKeys.DELIVERY_ADDRESS] = addressJson
        }
    }

    override suspend fun getDefaultPaymentMethod(): PaymentMethod? {
        val paymentMethodJson = context.checkoutDataStore.data
            .map { preferences ->
                preferences[PreferencesKeys.DEFAULT_PAYMENT_METHOD]
            }
            .first()

        return if (paymentMethodJson != null) {
            json.decodeFromString<PaymentMethod>(paymentMethodJson)
        } else {
            null
        }
    }

    override suspend fun addPaymentMethod(paymentMethod: PaymentMethod, setAsDefault: Boolean) {
        // Get existing payment methods
        val methodsJson = context.checkoutDataStore.data
            .map { preferences ->
                preferences[PreferencesKeys.PAYMENT_METHODS]
            }
            .first()

        // Parse existing payment methods or initialize empty list
        val existingMethods = if (methodsJson != null) {
            json.decodeFromString<List<PaymentMethod>>(methodsJson).toMutableList()
        } else {
            mutableListOf()
        }

        // Add new payment method
        existingMethods.add(paymentMethod)

        // Save updated list
        val updatedMethodsJson = json.encodeToString(existingMethods)
        context.checkoutDataStore.edit { preferences ->
            preferences[PreferencesKeys.PAYMENT_METHODS] = updatedMethodsJson
        }

        // Set as default if requested
        if (setAsDefault) {
            val defaultMethodJson = json.encodeToString(paymentMethod)
            context.checkoutDataStore.edit { preferences ->
                preferences[PreferencesKeys.DEFAULT_PAYMENT_METHOD] = defaultMethodJson
            }
        }
    }

    override suspend fun placeOrder(): String {
        // Generate a random order ID
        val orderId = UUID.randomUUID().toString()

        // Get cart items
        val cartItems = cartRepository.getCartItems().first()

        // Get cart total
        val subtotal = cartItems.sumOf { it.price * it.quantity }

        // Get delivery address
        val deliveryAddress = getDeliveryAddress()

        // Get payment method
        val paymentMethod = getDefaultPaymentMethod()
            ?: throw IllegalStateException("No payment method available")

        // Mock fees
        val bagFee = 0.40
        val smallOrderFee = if (subtotal < 10.0) 3.99 else 0.0
        val serviceFee = 1.25
        val deliveryFee = 3.99
        val tip = 0.0

        // Calculate total
        val total = subtotal + bagFee + smallOrderFee + serviceFee + deliveryFee + tip

        // Create order - In a real app, this would be saved to a database or sent to a server
        val currentTime = System.currentTimeMillis()
        val deliveryTime = currentTime + 45 * 60 * 1000 // 45 minutes later

        // In a real implementation, you would create and save the order here
        // For example with serialization:
        /*
        val order = Order(
            id = orderId,
            items = cartItems,
            subtotal = subtotal,
            bagFee = bagFee,
            smallOrderFee = smallOrderFee,
            serviceFee = serviceFee,
            deliveryFee = deliveryFee,
            tip = tip,
            total = total,
            paymentMethodId = paymentMethod.id,
            deliveryAddress = deliveryAddress,
            orderDate = currentTime,
            estimatedDeliveryTime = deliveryTime
        )

        // Save order to local database or remote server
        // orderDao.insertOrder(order)
        // or
        // apiService.createOrder(order)
        */

        return orderId
    }
}