## Para executar:
  - É preciso buildar o projeto e executá-lo. Caso o mapa não carregue, provavelmente será preciso gerar uma nova API key do Google no https://console.developers.google.com. Após tê-la em mãos, siga os próximos passos:
    -- Vá até o arquivo "google_maps_api.xml" na pasta ./aliensDoGramado/app/src/main/res/values
    -- atualize o seguinte campo: <string name="google_maps_key" templateMergeStrategy="preserve" translatable="false">$$$$$ Add a KEY aqui $$$$$</string>
    -- Build e execute o projeto novamente
