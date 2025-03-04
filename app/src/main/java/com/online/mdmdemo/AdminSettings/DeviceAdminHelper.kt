package com.online.mdmdemo.AdminSettings

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.Toast

//We are making it device admin here on button click
//This is not preferred way to make our app device admin,
//preferred way is to use QR code or using afw#mdm_name
class DeviceAdminHelper(private val context: Context) {

    private val devicePolicyManager =
        context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
    private val componentName = ComponentName(context, MyDeviceAdminReceiver::class.java)

    fun activateAdmin() {
        if (!devicePolicyManager.isAdminActive(componentName)) {
            val intent = Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN).apply {
                putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName)
                putExtra(
                    DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                    "Admin access is needed to manage device policies."
                )
            }
            context.startActivity(intent)
        } else {
            Toast.makeText(context, "Already Device Admin", Toast.LENGTH_SHORT).show()
        }
    }

    fun deactivateAdmin() {
        if (devicePolicyManager.isAdminActive(componentName)) {
            devicePolicyManager.removeActiveAdmin(componentName)
            Toast.makeText(context, "Device Admin Disabled", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "App is not a Device Admin", Toast.LENGTH_SHORT).show()
        }
    }
}