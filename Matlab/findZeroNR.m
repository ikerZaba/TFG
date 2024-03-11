function zeroAt = findZeroNR(p,maxVal,MinVal)
    zeroAt = floor((maxVal+MinVal)/2);
    maxIter = 10;
    i = 0;

    while i<maxIter & polyval(p,zeroAt)~=0
        zeroAt = zeroAt - (polyval(p,zeroAt)/polyder(p,zeroAt));
        i++;
    end
end