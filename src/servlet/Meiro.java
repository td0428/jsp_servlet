package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Meiro
 */
@WebServlet("/Meiro")
public class Meiro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//	変数
	public String[][] bord;
	private int width;
	private int height;
	private int pointX;
	private int pointY;
	boolean SG = true;
	int root = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	*/
	public Meiro() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String math = request.getParameter("math");

		int ma = Integer.parseInt(math);

		stert(ma);
		ma = ma + 2;

		request.setAttribute("math", ma);
		request.setAttribute("bord", bord);
		request.getRequestDispatcher("jsp/meiro/meiro.jsp").forward(request, response);
	}

	//	配列の作成
	public void stert(int i) {
		width = i + 2;
		height = i + 2;
		bord = new String[width][height];
		make();
	}

	//配列の初期化
	private void make() {
		for (int a = 0; a < width; a++) {
			bord[a][0] = "□";
			bord[width - 1][a] = "□";

		}
		for (int s = 0; s < height; s++) {
			bord[0][s] = "□";
			bord[s][height - 1] = "□";

		}

		for (int i = 1; i < width - 1; i++) {
			for (int j = 1; j < height - 1; j++) {
				bord[i][j] = "■";

			}
		}
		hole();
	}

	//スタート地点を作成
	private void hole() {
		do {
			Random randX = new Random();
			Random randY = new Random();
			pointX = randX.nextInt(width);
			pointY = randY.nextInt(height);

			if (pointX == 0 || pointY == 0 || pointX == width || pointY == height || pointX == 1 || pointY == 1
					|| pointX == width - 1
					|| pointY == height - 1) {
				continue;
			} else if (pointX % 2 == 0 && pointY % 2 == 0) {
				bord[pointX][pointY] = "Ｓ";
			}

		} while (pointX % 2 == 1 || pointY % 2 == 1 || pointX == 0 || pointY == 0 || pointX == width || pointY == height
				|| pointX == 1 || pointY == 1
				|| pointX == width - 1
				|| pointY == height - 1);
		road();
	}

	//スタートからゴールまでの道を作成
	private void road() {

		do {
			Random VectorRandom = new Random();
			int vector = VectorRandom.nextInt(4);
			switch (vector) {
			case 0:
				if (bord[pointX - 2][pointY].equals("■")) {
					bord[pointX - 1][pointY] = "　";
					bord[pointX - 2][pointY] = "　";
					pointX = pointX - 2;
				}
				break;
			case 1:
				if (bord[pointX][pointY + 2].equals("■")) {
					bord[pointX][pointY + 1] = "　";
					bord[pointX][pointY + 2] = "　";
					pointY = pointY + 2;
				}
				break;
			case 2:
				if (bord[pointX + 2][pointY].equals("■")) {
					bord[pointX + 1][pointY] = "　";
					bord[pointX + 2][pointY] = "　";
					pointX = pointX + 2;
				}
				break;
			case 3:
				if (bord[pointX][pointY - 2].equals("■")) {
					bord[pointX][pointY - 1] = "　";
					bord[pointX][pointY - 2] = "　";
					pointY = pointY - 2;
				}
				break;
			}
		} while (bord[pointX - 2][pointY].equals("■") || bord[pointX][pointY + 2].equals("■")
				|| bord[pointX + 2][pointY].equals("■") || bord[pointX][pointY - 2].equals("■"));

		if (SG) {
			bord[pointX][pointY] = "Ｇ";
			SG = false;
		}

		Nextroad();
	}

	//	分かれ道を作成（１００回ループさせて隙間をなくしている）
	private void Nextroad() {
		do {
			Random VectorRandom = new Random();
			int NextVector = VectorRandom.nextInt(4);
			switch (NextVector) {
			case 0:
				if (bord[pointX - 2][pointY].equals("　")) {
					pointX = pointX - 2;
					road();
				}
				break;
			case 1:
				if (bord[pointX][pointY + 2].equals("　")) {
					pointY = pointY + 2;
					road();
				}
				break;
			case 2:
				if (bord[pointX + 2][pointY].equals("　")) {
					pointX = pointX + 2;
					road();
				}
				break;
			case 3:
				if (bord[pointX][pointY - 2].equals("　")) {
					pointY = pointY - 2;
					road();
				}
				break;
			}
			root++;
		} while (root < 100);

	}

}
