#include <iostream>
#include <iomanip>
#include <ctime>
#include <conio.h>

using namespace std;

#define size 4
int board[size][size];

void ran()
{

    srand(time(0));

    while (true)
    {

        int i = rand() % size;
        int j = rand() % size;
        int test = rand() % 3;
        if (test != 0 && test != 1)
        {
            if (board[i][j] == 0)
            {
                board[i][j] = test;
                break;
            }
        }
    }
    while (true)
    {

        int i = rand() % size;
        int j = rand() % size;

        int test = rand() % 3;
        if (test != 0 && test != 1)
        {
            if (board[i][j] == 0 && board[i][j] != 2)
            {
                board[i][j] = test;
                return;
            }
        }
    }
}

void print()
{
    ran();
    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < size; j++)
        {
            cout << setw(4) << board[i][j];
        }
        cout << '\n';
    }
}

int main()
{
    print();

    while (_kbhit)
    {
        char a = _getch();

        if (a == (char)13)
        {
            return 0;
        }

        else if (a == char(77))
        {
            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size - 1; j++)
                {
                    if (board[i][j] > 0)
                    {
                        if (board[i][j] == board[i][j + 1])
                        {
                            board[i][j + 1] = board[i][j] * 2;
                        }
                        else
                        {
                            if (board[i][j] == 0)
                            {
                                int temp;
                                temp = board[i][j];
                                board[i][j] = board[i][j + 1];
                                board[i][j] = temp;
                            }
                        }
                    }
                    else
                    {
                        int temp;

                        temp = board[i][j];
                        board[i][j] = board[i][j + 1];
                        board[i][j] = temp;
                    }
                }
            }
        }
        system("cls");
        print();
    }
}
