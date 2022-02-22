#include <iostream>
#include <stdio.h>
#include <stdlib.h>

#include "tests.h"

int main()
{
	Tests t;
    t.test_dealt_two_cards();
    t.run_test();
	return 0;
}