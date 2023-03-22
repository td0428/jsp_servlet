package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Connect_Four
 */
@WebServlet("/Connect_Four")
public class Connect_Four extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArrayList<String> bord = new ArrayList<String>();
	ArrayList<String> bord1 = new ArrayList<String>();

	static int column_0 = 35, column_1 = 36, column_2 = 37, column_3 = 38, column_4 = 39, column_5 = 40, column_6 = 41;
	static int turn = -1;
	static String maru = "Ｏ", batu = "Ｘ";
	boolean ColumnEnd = false;
	int battle = 0;
	Boolean NoStart = false;
	int finish1 = -1 ,finish2 = -1 ,finish3 = -1 ,finish4 = -1 ;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ここから入力

		//開始時のみ実行
		if (turn == -1) {
			for (int i = 0; i < 42; i++) {
				bord.add("[　]");
			}
			turn++;
			ArrayList<String> bord1 = new ArrayList<String>(bord);
			request.setAttribute("finish1",finish1);
			request.setAttribute("finish2",finish2);
			request.setAttribute("finish3",finish3);
			request.setAttribute("finish4",finish4);
			request.setAttribute("NoStart", NoStart);
			request.setAttribute("bord", bord1);
			request.setAttribute("battle", battle);
			request.setAttribute("ColumnEnd", ColumnEnd);
			request.getRequestDispatcher("jsp/connect_four/bord.jsp").forward(request, response);
		}

		//radiobuttonを選択しなかったら何もしない
		if (request.getParameter("radiobutton") == null) {
			NoStart = true;
			ArrayList<String> bord1 = new ArrayList<String>(bord);
			request.setAttribute("finish1",finish1);
			request.setAttribute("finish2",finish2);
			request.setAttribute("finish3",finish3);
			request.setAttribute("finish4",finish4);
			request.setAttribute("NoStart", NoStart);
			request.setAttribute("bord", bord1);
			request.setAttribute("battle", battle);
			request.setAttribute("ColumnEnd", ColumnEnd);
			request.getRequestDispatcher("jsp/connect_four/bord.jsp").forward(request, response);
		}

		//radiobuttonを選択すると、ここから下が実行される
		NoStart = false;


		//radiobuttonで選択した列がselectに入る
		String select = request.getParameter("radiobutton");

		//gameメソッドで列に対しての処理を実行
		game(select);

		//勝敗判定
		tate();
		yoko();
		nana1();
		nana2();

		ArrayList<String> bord1 = new ArrayList<String>(bord);
		request.setAttribute("finish1",finish1);
		request.setAttribute("finish2",finish2);
		request.setAttribute("finish3",finish3);
		request.setAttribute("finish4",finish4);
		request.setAttribute("NoStart", NoStart);
		request.setAttribute("battle", battle);
		request.setAttribute("ColumnEnd", ColumnEnd);
		request.setAttribute("bord", bord1);
		request.getRequestDispatcher("jsp/connect_four/bord.jsp").forward(request, response);
	}

	public void game(String game) {
		switch (game) {
		//ボタンで選択した場所で実行
		case "0":
			if (column_0 < 0) {
				ColumnEnd = true;
			} else {
				if (turn % 2 == 0) {
					bord.set(column_0, "[" + maru + "]");
				} else {
					bord.set(column_0, "[" + batu + "]");
				}
				turn++;
				column_0 = column_0 - 7;
				ColumnEnd = false;
			}
			break;
		case "1":
			if (column_1 < 1) {
				ColumnEnd = true;
			} else {
				if (turn % 2 == 0) {
					bord.set(column_1, "[" + maru + "]");
				} else {
					bord.set(column_1, "[" + batu + "]");
				}
				turn++;
				column_1 = column_1 - 7;
				ColumnEnd = false;
			}
			break;
		case "2":
			if (column_2 < 2) {
				ColumnEnd = true;
			} else {
				if (turn % 2 == 0) {
					bord.set(column_2, "[" + maru + "]");
				} else {
					bord.set(column_2, "[" + batu + "]");
				}
				turn++;
				column_2 = column_2 - 7;
				ColumnEnd = false;
			}
			break;
		case "3":
			if (column_3 < 3) {
				ColumnEnd = true;
			} else {
				if (turn % 2 == 0) {
					bord.set(column_3, "[" + maru + "]");
				} else {
					bord.set(column_3, "[" + batu + "]");
				}
				turn++;
				column_3 = column_3 - 7;
				ColumnEnd = false;
			}
			break;
		case "4":
			if (column_4 < 4) {
				ColumnEnd = true;
			} else {
				if (turn % 2 == 0) {
					bord.set(column_4, "[" + maru + "]");
				} else {
					bord.set(column_4, "[" + batu + "]");
				}
				turn++;
				column_4 = column_4 - 7;
				ColumnEnd = false;
			}
			break;
		case "5":
			if (column_5 < 5) {
				ColumnEnd = true;
			} else {
				if (turn % 2 == 0) {
					bord.set(column_5, "[" + maru + "]");
				} else {
					bord.set(column_5, "[" + batu + "]");
				}
				turn++;
				column_5 = column_5 - 7;
				ColumnEnd = false;
			}
			break;
		case "6":
			if (column_6 < 6) {
				ColumnEnd = true;
			} else {
				if (turn % 2 == 0) {
					bord.set(column_6, "[" + maru + "]");
				} else {
					bord.set(column_6, "[" + batu + "]");
				}
				turn++;
				column_6 = column_6 - 7;
				ColumnEnd = false;
			}
			break;
		}

	}

	public void yoko() {
		//横の判定
		for (int i = 0; i < 42; i++) {
			try {
				if (4 <= i && i <= 6 || 11 <= i && i <= 13 || 18 <= i && i <= 20 || 25 <= i && i <= 27
						|| 32 <= i && i <= 34 || 39 <= i && i <= 41) {
					continue;
				}
				if (bord.get(i).equals("[" + maru + "]")) {
					if (bord.get(i + 1).equals("[" + maru + "]")) {
						if (bord.get(i + 2).equals("[" + maru + "]")) {
							if (bord.get(i + 3).equals("[" + maru + "]")) {
								battle = 1;
								finish1 = i;
								finish2 = i + 1;
								finish3 = i + 2;
								finish4 = i + 3;
							}

						}

					}
				}
				if (bord.get(i).equals("[" + batu + "]")) {
					if (bord.get(i + 1).equals("[" + batu + "]")) {
						if (bord.get(i + 2).equals("[" + batu + "]")) {
							if (bord.get(i + 3).equals("[" + batu + "]")) {
								battle = 2;
								finish1 = i;
								finish2 = i + 1;
								finish3 = i + 2;
								finish4 = i + 3;
							}

						}

					}
				}
			} catch (Exception e) {

			}
		}

	}

	public void tate() {
		for (int i = 0; i < 42; i++) {
			//縦の判定
			try {
				if (bord.get(i).equals("[" + maru + "]")) {
					if (bord.get(i + 7).equals("[" + maru + "]")) {
						if (bord.get(i + 14).equals("[" + maru + "]")) {
							if (bord.get(i + 21).equals("[" + maru + "]")) {
								battle = 1;
								finish1 = i;
								finish2 = i + 7;
								finish3 = i + 14;
								finish4 = i + 21;
							}

						}

					}
				}
				if (bord.get(i).equals("[" + batu + "]")) {
					if (bord.get(i + 7).equals("[" + batu + "]")) {
						if (bord.get(i + 14).equals("[" + batu + "]")) {
							if (bord.get(i + 21).equals("[" + batu + "]")) {
								battle = 2;
								finish1 = i;
								finish2 = i + 7;
								finish3 = i + 14;
								finish4 = i + 21;
							}

						}

					}
				}
			} catch (Exception e) {
			}
		}
	}

	public void nana1() {
		for (int i = 0; i < 42; i++) {
			//斜めの判定（左上方向）
			try {
				if (4 <= i && i <= 6 || 11 <= i && i <= 13 || 18 <= i && i <= 20 || 25 <= i && i <= 27
						|| 32 <= i && i <= 34 || 39 <= i && i <= 41) {
					continue;
				}
				if (bord.get(i).equals("[" + maru + "]")) {
					if (bord.get(i + 8).equals("[" + maru + "]")) {
						if (bord.get(i + 16).equals("[" + maru + "]")) {
							if (bord.get(i + 24).equals("[" + maru + "]")) {
								battle = 1;
								finish1 = i;
								finish2 = i + 8;
								finish3 = i + 16;
								finish4 = i + 24;
							}

						}

					}
				}
				if (bord.get(i).equals("[" + batu + "]")) {
					if (bord.get(i + 8).equals("[" + batu + "]")) {
						if (bord.get(i + 16).equals("[" + batu + "]")) {
							if (bord.get(i + 24).equals("[" + batu + "]")) {
								battle = 2;
								finish1 = i;
								finish2 = i + 8;
								finish3 = i + 16;
								finish4 = i + 24;
							}

						}

					}
				}
			} catch (Exception e) {

			}
		}
	}

	public void nana2() {
		for (int i = 0; i < 42; i++) {
			//斜めの判定（右上方向）
			try {
				if (0 <= i && i <= 2 || 7 <= i && i <= 9 || 14 <= i && i <= 16 || 21 <= i && i <= 23
						|| 28 <= i && i <= 30 || 35 <= i && i <= 37) {
					continue;
				}
				if (bord.get(i).equals("[" + maru + "]")) {
					if (bord.get(i + 6).equals("[" + maru + "]")) {
						if (bord.get(i + 12).equals("[" + maru + "]")) {
							if (bord.get(i + 18).equals("[" + maru + "]")) {
								battle = 1;
								finish1 = i;
								finish2 = i + 6;
								finish3 = i + 12;
								finish4 = i + 18;
							}

						}

					}
				}
				if (bord.get(i).equals("[" + batu + "]")) {
					if (bord.get(i + 6).equals("[" + batu + "]")) {
						if (bord.get(i + 12).equals("[" + batu + "]")) {
							if (bord.get(i + 18).equals("[" + batu + "]")) {
								battle = 2;
								finish1 = i;
								finish2 = i + 6;
								finish3 = i + 12;
								finish4 = i + 18;
							}

						}

					}
				}
			} catch (Exception e) {

			}
		}
	}
}
