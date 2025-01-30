import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 * <p>
 * 명령은 총 여덟 가지이다.
 * <p>
 * push_front X: 정수 X를 덱의 앞에 넣는다.
 * push_back X: 정수 X를 덱의 뒤에 넣는다.
 * pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 덱에 들어있는 정수의 개수를 출력한다.
 * empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
 * front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */

public class Main {

    public class CustomDeque {
        List<Integer> numbers;

        public CustomDeque() {
            numbers = new ArrayList<>();
        }

        public void push_front(int number) {
            numbers.add(number);
        }

        public void push_back(int number) {
            numbers.add(0, number);
        }

        public void pop_front() {
            System.out.println(numbers.get(0));
            numbers.remove(0);
        }

        public void pop_back() {
            System.out.println(numbers.get(numbers.size() - 1));
            numbers.remove(numbers.size() - 1);
        }

        public void size() {
            System.out.println(numbers.size());
        }

        public void empty() {
            System.out.println(numbers.isEmpty() ? 1 : 0);
        }

        public void front() {
            System.out.println(numbers.get(0));
        }

        public void back() {
            System.out.println(numbers.get(numbers.size() - 1));
        }
    }

    public static void main(String[] args) throws IOException {

        class CustomDeque {
            List<Integer> numbers;

            public CustomDeque() {
                numbers = new ArrayList<>();
            }

            public void push_front(int number) {
                numbers.add(0,number);
            }

            public void push_back(int number) {
                numbers.add(number);
            }

            public void pop_front() {
                if (numbers.isEmpty()) {
                    System.out.println(-1);
                    return;
                }
                System.out.println(numbers.get(0));
                numbers.remove(0);
            }

            public void pop_back() {
                if (numbers.isEmpty()) {
                    System.out.println(-1);
                    return;
                }
                System.out.println(numbers.get(numbers.size() - 1));
                numbers.remove(numbers.size() - 1);
            }

            public void size() {
                System.out.println(numbers.size());
            }

            public void empty() {
                System.out.println(numbers.isEmpty() ? 1 : 0);
            }

            public void front() {
                if (numbers.isEmpty()) {
                    System.out.println(-1);
                    return;
                }
                System.out.println(numbers.get(0));
            }

            public void back() {
                if (numbers.isEmpty()) {
                    System.out.println(-1);
                    return;
                }
                System.out.println(numbers.get(numbers.size() - 1));
            }
        }

        CustomDeque deque = new CustomDeque();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int roof = Integer.parseInt(br.readLine());

        for (int i = 0; i < roof; i++) {
            String[] split = br.readLine().split(" ");

            switch (split[0]) {
                case "push_front":
                    deque.push_front(Integer.parseInt(split[1]));
                    break;
                case "push_back":
                    deque.push_back(Integer.parseInt(split[1]));
                    break;
                case "pop_front":
                    deque.pop_front();
                    break;
                case "pop_back":
                    deque.pop_back();
                    break;
                case "size":
                    deque.size();
                    break;
                case "empty":
                    deque.empty();
                    break;
                case "front":
                    deque.front();
                    break;
                case "back":
                    deque.back();
                    break;
            }
        }
    }
}