import sys


def main():
    input_file_name = sys.argv[1]
    input_file = open(input_file_name, "r")
    number_test_cases = int(input_file.readline().rstrip())
    X = 1
    Y = 0
    for i in range(1, number_test_cases + 1):
        print("Case %d:" % i)
        M = int(input_file.readline().rstrip())
        piratesM = ""
        for j in range(1, M + 1):
            T = int(input_file.readline().rstrip())
            piratesT = input_file.readline().rstrip()
            piratesT = piratesT * T
            piratesM += piratesT

        arr = [int(i) for i in str(piratesM)]
        n = len(arr)


        Q = int(input_file.readline())
        output_num = 1
        for j in range(1, Q + 1):
            char, a, b = input_file.readline().rstrip().split(" ")
            a = int(a)
            b = int(b)
            if char == 'F':
                for z in range(a, b + 1):
                    arr[z] = X
            elif char == 'E':
                for z in range(a, b + 1):
                    arr[z] = Y

            elif char == 'I':
                for z in range(a, b + 1):
                    arr[z] ^= 1

            elif char == 'S':
                sum = 0
                for z in range(a, b + 1):
                    sum += arr[z]
                print("Q%d: %d" % (output_num, sum))
                output_num += 1

    input_file.close()


if __name__ == "__main__":
    main()
