package com.example.broadcastbestpractice.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.broadcastbestpractice.R;

public class LoginActivity extends BaseActivity implements OnClickListener {

	private EditText accountEdit;
	private EditText passwordEdit;
	private Button loginButton;
	private CheckBox rememberPassCheckBox;
	private SharedPreferences pre;
	private SharedPreferences.Editor edit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		accountEdit = (EditText) findViewById(R.id.account);
		passwordEdit = (EditText) findViewById(R.id.password);
		loginButton = (Button) findViewById(R.id.login);
		rememberPassCheckBox = (CheckBox) findViewById(R.id.remember);
		pre = getPreferences(Context.MODE_PRIVATE);
		loginButton.setOnClickListener(this);
		boolean rememberpassword = pre.getBoolean("rememberpassword", false);
		rememberPassCheckBox.setChecked(rememberpassword);
		if (rememberpassword) {		// »Áπ˚±£¥Ê¡À’Àªß∫Õ√‹¬Î,æÕÃÓ≥‰
			loadData();
		}
	}

	private void loadData() {
		String account = pre.getString("account", "");
		String password = pre.getString("password", "");
		accountEdit.setText(account);
		passwordEdit.setText(password);
	}

	@Override
	public void onClick(View v) {
		if (R.id.login == v.getId()) {
			String account = accountEdit.getText().toString();
			String password = passwordEdit.getText().toString();
			if (account == null || "".equals(account)) {
				Toast.makeText(this, "«Î ‰»Î’À∫≈£°", Toast.LENGTH_SHORT).show();
				return;
			}
			if (password == null || "".equals(password)) {
				Toast.makeText(this, "«Î ‰»Î√‹¬Î£°", Toast.LENGTH_SHORT).show();
				return;
			}
			if ("admin".equals(account) && "123".equals(password)) {
				edit = pre.edit();
				if (rememberPassCheckBox.isChecked()) {
					edit.putBoolean("rememberpassword", true);
					edit.putString("account", account);
					edit.putString("password", password);
				} else {
					edit.clear();
				}
				edit.commit();

				Intent intent = new Intent(this, MainActivity.class);
				startActivity(intent);
				finish();
			} else {
				Toast.makeText(this, "’À∫≈ªÚ√‹¬Î¥ÌŒÛ£°", Toast.LENGTH_SHORT).show();
			}

		}
	}
}
