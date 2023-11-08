
horasextras= float (input("\nInforme o numero de horas extras"))
faltas= float (input("\nInforme o quantitativo de faltas "))
premio= horasextras-(2/3*faltas)*60
print("\n\n",horasextras)
if horasextras>=2.401 :
    print("O valor do premio é :R$500")
elif horasextras >=1.801 :
    print("o valor do premio é :R$400")
elif horasextras >= 1.201 :
 print("o valor do premio é :R$300")
elif horasextras >= 680:
 print("o valor do premio é :R$200")
else :
 print("o valor do premio é :R$100")   