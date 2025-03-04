package com.online.mdmdemo

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.online.mdmdemo.AdminSettings.DeviceAdminHelper
import com.online.mdmdemo.permissions.PermissionHelper

class MainActivity : AppCompatActivity() {

    private lateinit var deviceAdminHelper: DeviceAdminHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupUI()

        deviceAdminHelper = DeviceAdminHelper(this)
        setupButtons()
        PermissionHelper.requestAllPermissions(this)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        PermissionHelper.handlePermissionResults(this, permissions, grantResults)
    }

    private fun setupUI() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupButtons() {
        findViewById<Button>(R.id.btnActivate).setOnClickListener {
            deviceAdminHelper.activateAdmin()
        }
        findViewById<Button>(R.id.btnDeactivate).setOnClickListener {
            deviceAdminHelper.deactivateAdmin()
        }
    }
}