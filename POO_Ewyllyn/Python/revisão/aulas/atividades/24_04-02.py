n=0.1
quant=0
soma=0.0

while n > 0 :
    n = float(input("digite um número:"))
    soma = soma + n
    if n > -1:
        quant = quant+1
        media =soma / quant
        print("\n\nvocê digitou",quant,"numeros")
        print("A media dos valores digitados é",media)
        print("\n\n\n")



