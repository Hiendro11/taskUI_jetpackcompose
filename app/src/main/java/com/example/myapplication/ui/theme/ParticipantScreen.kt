package com.example.myapplication.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddParticipantDialog(
    onDismissRequest: () -> Unit,
    onAddParticipant: (String, String) -> Unit
) {

    var username by remember { mutableStateOf(TextFieldValue("")) }
    var role by remember { mutableStateOf(TextFieldValue("")) }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Text(
                text = "Add participant",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Username Text Field
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    placeholder = { Text("Enter username") },
                    leadingIcon = {
                        Icon(Icons.Default.Person, contentDescription = "Username Icon")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color(0xFFF0F0F0),
                        focusedBorderColor = Color.DarkGray,
                        unfocusedBorderColor = Color.DarkGray
                    )
                )

                // Role Text Field
                OutlinedTextField(
                    value = role,
                    onValueChange = { role = it },
                    label = { Text("Role") },
                    placeholder = { Text("Enter role") },
                    leadingIcon = {
                        Icon(Icons.Default.AccountCircle, contentDescription = "Role Icon")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color(0xFFF0F0F0),
                        focusedBorderColor = Color.DarkGray,
                        unfocusedBorderColor = Color.DarkGray
                    )
                )
            }
        },
        confirmButton = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        onAddParticipant(username.text, role.text)
                        onDismissRequest()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    shape = RoundedCornerShape(2.dp)
                ) {
                    Text("Add", color = Color.White)
                }
            }
        },

        shape = RoundedCornerShape(12.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun AddParticipantDialogPreview() {
    AddParticipantDialog(
        onDismissRequest = {},
        onAddParticipant = { _, _ -> }
    )
}
@Composable
fun ParentScreen() {
    var showDialog by remember { mutableStateOf(false) }

    // Button to trigger the dialog
    Button(onClick = { showDialog = true }) {
        Text("Open Add Participant Dialog")
    }

    // Show the dialog when showDialog is true
    if (showDialog) {
        AddParticipantDialog(
            onDismissRequest = { showDialog = false },
            onAddParticipant = { username, role ->
                showDialog = false
            }
        )
    }
}

