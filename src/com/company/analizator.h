#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<fstream>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>
#include<conio.h>
 
using namespace std;
 
int isKeyword(char buffer[]) {
    char keywords[5][13] = { "Var", "Begin","End","Integer","Long Integer"};
    int i, flag = 0;
 
    for (i = 0; i < 5; ++i) {
        if (strcmp(keywords[i], buffer) == 0) {
            flag = 1;
            break;
        }
    }
 
    return flag;
}
 
int main() {
 
    setlocale(LC_ALL, "Russian");
 
    char ch; 
    char buffer[30];
    char operators[] = {'+','-','*','/'};
    char separators[] = ",;:()";
    char assignment[3] = {":="};
    char numeral[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
    ifstream fin("input.txt");
    int i, j = 0;
 
    if (!fin.is_open()) {
        cout << "Ошибка при открытии файла\n";
        _getch(); 
        return 0;
    }
 
    while (!fin.eof()) {
        ch = fin.get();
 
        for (i = 0; i < 10; i++) {
            if (ch == operators[i]) {
                cout << ch << " Бинарный оператор\n";
            } else if (ch == separators[i]) {
                cout << ch << " Разделитель\n";
            } else if (ch == numeral[i]) {
                cout << ch << " Цифра\n";
            } else if (ch == assignment[i]) {
                cout << ch << " Оператор присваивания\n";
            }
        }
 
        if (isalnum(ch)) {
            buffer[j++] = ch;
        }
        else if ((ch == ' ' || ch == '\n') && (j != 0)) {
            buffer[j] = '\0';
            j = 0;
 
            if (isKeyword(buffer) == 1)
                cout << buffer << " Ключевое слово\n";
            else
                cout << buffer << " Переменная\n";
        }
 
    }
 
    fin.close();
 
    _getch();
    return 0;
}