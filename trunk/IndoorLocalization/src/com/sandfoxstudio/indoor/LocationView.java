package com.sandfoxstudio.indoor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class LocationView extends View {

	private String text = null;
	private int backgroundColor = Color.DKGRAY;
	private float x, y;
	static Boolean flag = false;

	// 속성이 없는 생성자는 소스상에서 직접 생성할때만 쓰인다. 
	public LocationView(Context context) {
		super(context);
		Log.w("sandfox", "CustomView(" + context + ")");
	}

	/*
	 * 리소스 xml 파일에서 정의하면 이 생성자가 사용된다.
	 * 
	 * 대부분 this 를 이용해 3번째 생성자로 넘기고 모든 처리를 3번째 생성자에서 한다.
	 */
	public LocationView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
		Log.w("sandfox", "CustomView(" + context + "," + attrs + ")");
	}

	/*
	 * xml 에서 넘어온 속성을 멤버변수로 셋팅하는 역할을 한다.
	 */
	public LocationView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		this.text = attrs.getAttributeValue(null, "text");

		Log.w("sandfox", "CustomView(" + context + "," + attrs + "," + defStyle + "),text:" + text);
	}

	@Override
	protected void onFinishInflate() {
		// TODO Auto-generated method stub
		super.onFinishInflate();
		setClickable(false);
		Log.w("sandfox", "onFinishInflate()");
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
		x = (float) (this.getWidth() / 2);
		y = (float) (this.getHeight() / 2);
		Log.w("sandfox", "onLayout(" + changed + "," + left + "," + top + "," + right + "," + bottom + ")");
	}

	@Override
	protected void onDraw(Canvas canvas) {

		final Paint p = new Paint();
		//		p.setColor(backgroundColor);
		//		canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), p);
		this.setBackgroundColor(backgroundColor);
		p.setColor(Color.CYAN);
		if (text != null || flag == false) {
			p.setColor(Color.RED);
			canvas.drawText(text, x + 10, y - 10, p); // 왼쪽 아래를 0,0 으로 보고있음		
			flag = true;
		}
		canvas.drawCircle(x, y, 1.0f, p);
		Log.w("sandfox", "onDraw(" + canvas + ")");
	}

	public void drawPoint(float ax, float ay) {
		this.x = ax;
		this.y = ay;
		this.invalidate();
	}
}
