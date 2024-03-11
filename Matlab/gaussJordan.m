%function recives a matrix with shape x1 x2 x3 x4 ... C
function resTable = gaussJordan(M)
    %Get the dimensions
    [rows,cols] = size(M);
    nVar = cols-1;
    for i=1:rows
        %convert the diagonal elements to 1
        if M(i,i)~=1
            M(i,:)= M(i,:)./M(i,i);   
        end

        %convert the other elements to 0 
            for n=1:rows
              if n~=i 
                  M(n,:)=-M(n,i).*M(i,:)+M(n,:);
              end              
            end     
    end
    disp(M);
    if rank(M)<nVar
        resTable = 0;
        disp("Compatible indeterminate");
    else if rank(M)>nVar
        resTable = 0;
        disp("Incompatible");
    else if rank(M(:rows,:ncols-1))<rank(M(:,cols))
        resTable = 0;
        disp("Incompatible");
    else
        for i=1:length(nVar)
            resTable(i) = M(i,cols);
            
        end
        disp(resTable);
    end
end