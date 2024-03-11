function resTable = gaussSeidel(M)
    [rows,cols] = size(M);
    nVar = cols-1;
    eps = 0.01;
    maxIter = 10;
    iter = 0;
    x = zeros(nVar);
    A = M(:rows,:nVar);
    B = M(:rows,:cols);
    error=Inf;
    while error > eps && iter < maxIter
        iter++;
        prevX = x;
        
        for i=1:nVar
        
            sigma=0;
            
            for j=1:i-1
                    sigma=sigma+A(i,j)*x(j);
            end
            
            for j=i+1:nVar
                    sigma=sigma+A(i,j)*prevX(j);
            end
            
            x(i)=(1/A(i,i))*(B(i)-sigma);
        end
        
        error=norm(prevX-x);
    end
    %condiciones de exito
    resTable = x;
end