package com.example.bakatest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	private double time;
	private TextView txtTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtTime = (TextView) findViewById(R.id.textView1);
		setText();
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_refresh:
			setText();
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	public void setText() {
//		 time = BubbleSort.sort();
//		time = IsPrime.isPrimeCalculation();
//		 time = PrimeFactors.primeFactors();
//		 time = MultiplyMatrices.multiply();
//		time = Quicksort.sort();
//		time = FloydWarshall.calculatePath();
		
//		long startTime = System.nanoTime();
//		NQueens q = new NQueens(12);
//		q.callplaceNqueens();
//		time = (System.nanoTime()-startTime)*1.0e-6;
		
//		time = TowersOfHanoi.move(10, 2, 6);
		time = GreatestCommonDivisor.calculateGCD();
		txtTime.setText(String.valueOf(time));
		System.out.println("Answer " + time);

	}

}
