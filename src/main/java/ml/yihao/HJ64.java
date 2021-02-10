package ml.yihao;

import java.util.*;

/**
 * MP3 Player因为屏幕较小，显示歌曲列表的时候每屏只能显示几首歌曲，用户要通过上下键才能浏览所有的歌曲。为了简化处理，假设每屏只能显示4首歌曲，光标初始的位置为第1首歌。
 *
 *
 * 现在要实现通过上下键控制光标移动来浏览歌曲列表，控制逻辑如下：
 */
public class HJ64 {
	public static void MP3PlayerLow4(String str, int n) {
			char[] ch = str.toCharArray();
			int begin = 1, cur = 1; // 起始序号，当前歌曲序号
			for (int i = 0; i < ch.length; i++) {
				if (cur == 1 && ch[i] == 'U') { // 光标在第一首歌曲上时，按Up键光标
					cur = n;
					continue;
				}
				if (cur == n && ch[i] == 'D') { // 光标在最后一首歌曲时，按Down键光标
					cur = 1;
					continue;
				}
				if (ch[i] == 'U') {
					cur -= 1;
				}
				if (ch[i] == 'D') {
					cur += 1;
				}
			}
			for (int i = 0; i < n; i++) {
				if (i==0) {
					System.out.print(begin);
				}else{
					System.out.print(" "+(begin+i));
				}
			}
			System.out.println();
			System.out.println(cur);
	}

	public static void MP3PlayerUp4(String str, int n) {
		char[] ch = str.toCharArray();
		int begin = 1, cur = 1; // 起始序号，当前歌曲序号
		for (int i = 0; i < ch.length; i++) {
			if (begin==1 && cur == 1 && ch[i] == 'U') { // 光标在第一页 ,第一首歌曲上时,按Up键光标
				cur = n;
				begin = n-3;
				continue;
			}
			if (begin==n-3 && cur == n && ch[i] == 'D') { // 光标在最后一页,最后一首歌曲时，按Down键光标
				cur   = 1;
				begin = 1;
				continue;
			}
			if (ch[i] == 'U' && begin==cur ) { 	// 光标在非第一页，第一首歌曲时，按Up键后，从当前歌曲的上一首开始显示，光标也挪到上一首歌曲。
				cur  -= 1;
				begin-= 1;
				continue;
			}
			if (ch[i] == 'D' && begin+3==cur) {
				cur  += 1;
				begin+= 1;
				continue;
			}
			if(ch[i] == 'U'){ 
				cur -= 1;
			}else{
				cur += 1;
			}
		}
		System.out.println(begin + " " + (begin + 1) + " " + (begin + 2)+ " " + (begin + 3));
		System.out.println(cur);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
			int n = input.nextInt(); // 歌曲数量
			String str = input.next(); // 操作序列
			if (n<=4) 
				MP3PlayerLow4(str, n);
			else
				MP3PlayerUp4(str, n);
		}
	}
}

