package Reseau;

import java.net.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		try { 
			ServerSocket s = new ServerSocket(3330); 
			while(true) {
				SocketServeur th = new SocketServeur(s.accept());
				th.start(); 
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
