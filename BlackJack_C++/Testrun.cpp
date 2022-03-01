#include <iostream>
#include <stdio.h>
#include <stdlib.h>

#include "tests.h"

int main()
{
	Tests t;
	auto start = std::chrono::system_clock::now();
	t.test_dealt_two_cards();
	t.test_score_compute();
	auto end = std::chrono::system_clock::now();	
	std::chrono::duration<double, std::milli> fp_ms = end - start;
	std::cout << "Time elapsed for the whole test " << fp_ms.count() << " ms " ;
	return 0;
}
