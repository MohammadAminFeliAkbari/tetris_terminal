#include <iostream>
using namespace std;

int main()
{
    int arr[5] = {1, 2, 0, 10, 14};
    int arr2[100];

    int sefr = 0;

    for (int i = 0; i < 5; i++)
    {
        if (arr[i] == 0)
        {
            sefr++;
        }
    }

    for (int j = 0; j < sefr; j++)
    {
        arr2[j] = 0;
    }

    int y = 0;

    for (int k = 0; k < 5; k++)
    {
        if (arr[k] != 0)
        {
            arr2[k + sefr] = arr[y];
            y++;
        }else{
            y--;
        }
        
    }

    for (int i = 0; i < 5; i++)
    {
        cout << arr2[i] << " ";
    }
    return 0;
}