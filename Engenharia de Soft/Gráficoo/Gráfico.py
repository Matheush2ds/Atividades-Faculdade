import matplotlib.pyplot as plt

def generate_burndown_chart(backlog, progress):
    total_work = sum(backlog)
    remaining_work = total_work
    ideal_burndown = [total_work]

    for p in progress:
        remaining_work -= p
        ideal_burndown.append(remaining_work)

    ideal_burndown.append(0)  # Adiciona o trabalho restante zero ao final

    # Plotando o gráfico burndown
    days = range(len(progress) + 1)  # Ajuste para ter o mesmo tamanho que progress
    
    backlog_line = [sum(backlog)] * (len(progress) + 1)  # Linha do backlog
    
    plt.plot(days[:-1], backlog_line[:-1], label='Backlog', linestyle='-', linewidth=2, color='orange')
    plt.plot(days, ideal_burndown[:len(progress)+1], label='Ideal', linestyle='--', linewidth=2, color='blue')
    plt.plot(days[:-1], progress, label='Progresso', linestyle='-', linewidth=2, color='green')

    # Adicionando marcações para cada ponto de progresso
    plt.scatter(days[:-1], progress, color='green', marker='o', s=80)

    plt.xlabel('Dias')
    plt.ylabel('Trabalho Restante')
    plt.title('Gráfico Burndown')
    plt.legend()
    plt.grid(True)

    # Adicionando anotações com os valores de trabalho restante
    for i, j in enumerate(progress):
        plt.annotate(str(j), xy=(i+0.5, j+0.5), xytext=(i+0.7, j+1), color='black', fontsize=10)

    plt.show()

# Dados do backlog e progresso
backlog = [2, 4, 6, 4, 4, 4, 6, 4, 8, 2]
progress = [2, 2, 4, 2, 2, 2, 4, 2, 6, 2]

# Gerar o gráfico burndown
generate_burndown_chart(backlog, progress)
