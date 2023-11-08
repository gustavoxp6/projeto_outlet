salario= float (input("\nInforme o salário do funcionário:"))
ano=2000
aumentosalarial=1.5/100
salario=1000

for x in range(18):
    print("O salario do funcionário do ano",ano,"foi de:",salario)
    aumentosalarial=aumentosalarial*2
    ano=ano+1
    salario=salario +(salario * aumentosalarial)
    








