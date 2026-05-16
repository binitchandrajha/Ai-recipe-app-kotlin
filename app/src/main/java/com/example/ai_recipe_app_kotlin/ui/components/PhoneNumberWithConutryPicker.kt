package com.example.ai_recipe_app_kotlin.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arpitkatiyarprojects.countrypicker.CountryPickerOutlinedTextField

@Composable
fun PhoneNumberWithCountryPicker(
    mobileNumber: String,
    selectedCountry: String,
    errorMessage: String?,
    onMobileNumberChange: (String) -> Unit,
    onCountrySelected: (String) -> Unit,
    onErrorMessageChange: (String?) -> Unit
){


    // Validation
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.size(10.dp))
        CountryPickerOutlinedTextField(
            mobileNumber = mobileNumber,
            onMobileNumberChange = { input ->
                val isAllDigits = input.all { it.isDigit() }

                when {
                    input.length > 10 -> {
                        onErrorMessageChange("Mobile number cannot be more than 10 digits")
                    }
                    !isAllDigits -> {
                        onErrorMessageChange("Mobile number can only contain digits")
                    }
                    else -> {
                        onErrorMessageChange(null)
                    }
                }
                onMobileNumberChange(input)
            },
            onCountrySelected = {
                onCountrySelected(it.countryCode)
            },
            defaultCountryCode = selectedCountry,
            label = {
                Text("Mobile Number")
            },
            isError = errorMessage != null,
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                if(errorMessage != null){
                    Text(errorMessage, color = Color.Red)
                }
            }
        )
    }
}

@Preview(showBackground = false)
@Composable
fun PhoneNumberWithCountryPickerPreview(){
    PhoneNumberWithCountryPicker(
        mobileNumber = "",
        selectedCountry = "NP",
        errorMessage = null,
        onMobileNumberChange = {},
        onCountrySelected = {},
        onErrorMessageChange = {}
    )
}