polynomial = [0.25 1.25 0.25 1.25];
tolerance = 0.001;
[M,m] = findInter(polynomial,tolerance);
rootPoint = findZeroNR(polynomial,M,m);
printInterval = ['Interval: [',m,',',M,']'];
printPoint = ['Zero at x=',rootPoint];
disp(printInterval);
disp(printPoint);