#include <iostream>
using namespace std;

int main() {
    int A, B, C;
    cin >> A >> B >> C;

		if ((B + C) >= 60) {
			A = A + ((B + C) / 60);
			B = (B + C) - 60;
			if (B % 60 == 0) {
				B = 0;
			} else {
				B = B - (B/60)*60; 
			}
			
			if (A >= 24) {
				A = A - 24;
			} else {
			}
			
			cout << A << " " << B << endl;
			
		} else {
			B = B + C;
			cout << A << " " << B << endl;
        }
    return 0;
}