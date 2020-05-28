package com.queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
	public static void main(String[] args) {
		PriorityQueue<Integer> queueNum = new PriorityQueue<>();
		queueNum.offer(1);
		queueNum.offer(4);
		queueNum.offer(3);
		queueNum.offer(2);
		queueNum.offer(5);
		System.out.println("queueNum: " + queueNum);
		
		System.out.println("Priority queue using Comparable:");
		while (queueNum.size() > 0) {
			System.out.print(queueNum.remove() + " ");
		}
		
		PriorityQueue<String> queueChar = new PriorityQueue<>();
		queueChar.offer("A");
		queueChar.offer("F");
		queueChar.offer("W");
		queueChar.offer("C");
		System.out.println("\nqueueChar:" + queueChar);
		
		System.out.println("Priority queue using Comparable:");
		while (queueChar.size() > 0) {
			System.out.print(queueChar.remove() + " ");
		}
		
		
		PriorityQueue<String> queue1 = new PriorityQueue<>();
		queue1.offer("Oklahoma");
		queue1.offer("Indiana");
		queue1.offer("Georgia");
		queue1.offer("Texas");
		System.out.println("\nqueue1:\n" + queue1);
		
		System.out.println("Priority queue using Comparable:");
		while (queue1.size() > 0) {
			System.out.print(queue1.remove() + " ");
		}
		
		System.out.println();
		
		PriorityQueue<String> queue2 = new PriorityQueue<>(
				4,Collections.reverseOrder());
		queue2.offer("Oklahoma");
		queue2.offer("Indiana");
		queue2.offer("Georgia");
		queue2.offer("Texas");
		System.out.println("\nqueue2:\n" + queue2);
		System.out.println("Priorty queue using Comparator:");
		while (queue2.size() > 0) {
			System.out.print(queue2.remove() + " ");
		}
	}

}

