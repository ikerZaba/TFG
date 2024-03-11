function [maxValue,minValue] = findInterval(p, tolerance)
    //bisection method
    maxIter = 5;
    i=0;
    maxValue = 1;
    minValue = 0;
    x = (minValue+maxValue)/2
    while polyval(p,x)>tolerance & i<maxIter & ((maxValue-minValue)/2)>tolerance
        if polyval(p,minVal)*polyval(p,x)>0
            minVal=x;
        else 
            maxVal=x;
        end
        i++;
    end
end